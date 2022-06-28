package fun.mizhuo.hrserver.util;

import fun.mizhuo.hrserver.exception.HrException;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/9/27 10:23 下午
 * @description: POI工具类
 */
public class PoiUtils {

    private static HSSFWorkbook workbook;

    /**
     * 初始化POI工具
     * @return
     */
    private static void initPOI(){
        //1:创建文档
        workbook = new HSSFWorkbook();
        //2:创建文档摘要
        workbook.createInformationProperties();
        //3:获取并配置文档信息
        DocumentSummaryInformation information = workbook.getDocumentSummaryInformation();
        //文档类别
        information.setCategory("机密");
        //文档管理员
        information.setManager("mizhuo");
        //公司名称
        information.setCompany("www.mizhuo.fun");
        //4:获取摘要信息
        SummaryInformation sumInfo = workbook.getSummaryInformation();
        //文档标题
        sumInfo.setTitle("机密表");
        //文档作者
        sumInfo.setAuthor("mizhuo");
        //文档备注
        sumInfo.setComments("mizhuo专用");
    }

    /**
     * 初始化表头
     * @param clazz
     * @param sheet
     * @throws IllegalAccessException
     */
    private static void initSheetHead(Class clazz,HSSFSheet sheet) {
        Field[] fields = clazz.getDeclaredFields();
        // 设置列头宽度
        for (int i = 0; i < fields.length; i++) {
            sheet.setColumnWidth(i, 4000);
        }
        // 设置默认行高
        sheet.setDefaultRowHeight((short) 400);
        // 构建头单元格样式
        CellStyle style = workbook.createCellStyle();
        //对齐方式设置
        style.setAlignment(HorizontalAlignment.CENTER);
        //边框颜色和宽度设置
        // 下边框
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        // 左边框
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        // 右边框
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        // 上边框
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        //设置背景颜色
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //粗体字设置
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        // 写入第一行各列的数据
        Row head = sheet.createRow(0);
        for (int i = 0,index = 0; i < fields.length; i++,index++) {
            if( Modifier.isStatic(fields[i].getModifiers())) {
                index --;
                continue;
            }
            fun.mizhuo.hrserver.anno.Field annotation = fields[i].getAnnotation(fun.mizhuo.hrserver.anno.Field.class);
            if(annotation.export()) {
                Cell cell = head.createCell(index);
                cell.setCellValue(annotation.value());
                cell.setCellStyle(style);
            }
        }
    }
    /**
     * 输出流
     * @return
     */
    private static ResponseEntity<byte[]> outExcelStream(String fileName) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", fileName + ".xls" );
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
        workbook.write(outByteStream);
        return new ResponseEntity<byte[]>(outByteStream.toByteArray(), headers, HttpStatus.OK);
    }

    /**
     * List转Excel导出
     * @param list
     * @return
     */
    public static ResponseEntity<byte[]> list2Excel(List<?> list,Class clazz,String fileName) throws HrException {
        try {
            initPOI();
            //创建列日期格式
            HSSFCellStyle dateCellStyle = workbook.createCellStyle();
            HSSFDataFormat dataFormat = workbook.createDataFormat();
            dateCellStyle.setDataFormat(dataFormat.getFormat("yyyy-MM-dd"));
            //创建列double格式
            HSSFCellStyle doubleCellStyle = workbook.createCellStyle();
            doubleCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
            //创建列int格式
            HSSFCellStyle intCellStyle = workbook.createCellStyle();
            intCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));
            //创建Sheet页
            HSSFSheet sheet = workbook.createSheet(fileName);
            //初始化sheet表头
            initSheetHead(clazz, sheet);
            Field[] fields = clazz.getDeclaredFields();
            //写数据
            for (int i = 0; i < list.size(); i++) {
                //表头占一行,从第二行开始创建
                HSSFRow row = sheet.createRow(i + 1);
                for (int j = 0, index = 0; j < fields.length; j++, index++) {
                    if (Modifier.isStatic(fields[j].getModifiers())) {
                        index--;
                        continue;
                    }
                    fun.mizhuo.hrserver.anno.Field annotation = fields[j].getAnnotation(fun.mizhuo.hrserver.anno.Field.class);
                    if (annotation != null && annotation.export()) {
                        HSSFCell cell = row.createCell(index);
                        fields[j].setAccessible(true);
                        Class<?> filedType = fields[j].getType();
                        Object fieldValue = fields[j].get(list.get(i));
                        if (Integer.class == filedType || Integer.TYPE == filedType) {
                            cell.setCellValue(fieldValue == null ? 0 : Integer.valueOf(String.valueOf(fieldValue)));
                            cell.setCellStyle(intCellStyle);
                        } else if (Long.class == filedType || Long.TYPE == filedType) {
                            cell.setCellValue(fieldValue == null ? 0 : Long.valueOf(String.valueOf(fieldValue)));
                            cell.setCellStyle(intCellStyle);
                        } else if (Short.class == filedType || Short.TYPE == filedType) {
                            cell.setCellValue(fieldValue == null ? 0 : Short.valueOf(String.valueOf(fieldValue)));
                            cell.setCellStyle(intCellStyle);
                        } else if (Double.class == filedType || Double.TYPE == filedType) {
                            cell.setCellValue(fieldValue == null ? 0 : Double.valueOf(String.valueOf(fieldValue)));
                            cell.setCellStyle(doubleCellStyle);
                        } else if (Float.class == filedType || Float.TYPE == filedType) {
                            cell.setCellValue(fieldValue == null ? 0 : Float.valueOf(String.valueOf(fieldValue)));
                            cell.setCellStyle(doubleCellStyle);
                        } else if (Date.class == filedType) {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            cell.setCellValue(fieldValue == null ? "" : dateFormat.format((Date) fieldValue));
                            cell.setCellStyle(dateCellStyle);
                        } else {
                            cell.setCellValue(String.valueOf(fieldValue));
                        }
                    }
                }
            }
            return outExcelStream(new String(fileName.getBytes("GBK"), "iso-8859-1"));
        }catch (Exception e){
            throw new HrException("导出Excel异常!请联系管理员!",e);
        }
    }

    /**
     * 导入Excel文件
     * @param file
     * @param clazz
     * @return
     * @throws HrException
     */
    public static List<?> excel2List(MultipartFile file, Class clazz) throws HrException {
        try {
            List<Object> data = new ArrayList<>();
            //读取Excel对象
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            //获取Sheet数量
            int sheetsSize = workbook.getNumberOfSheets();
            for (int sheetIndex = 0; sheetIndex < sheetsSize; sheetIndex++) {
                //获取Sheet
                HSSFSheet sheet = workbook.getSheetAt(sheetIndex);
                //获取行数
                int rowsSize = sheet.getPhysicalNumberOfRows();
                //第0行为表头,从第一行开始遍历
                for (int rowIndex = 1; rowIndex < rowsSize; rowIndex++) {
                    Object obj = clazz.newInstance();
                    //获取行数据
                    HSSFRow row = sheet.getRow(rowIndex);
                    //获取列数
                    int cellSize = row.getPhysicalNumberOfCells();
                    for (int cellIndex = 0; cellIndex < cellSize; cellIndex++) {
                        HSSFCell cell = row.getCell(cellIndex);
                        CellType cellType = cell.getCellType();
                        Object cellValue = null;
                        switch (cellType){
                            case NUMERIC:
                                cellValue = cell.getNumericCellValue();
                                break;
                            default:
                                cellValue = cell.getStringCellValue();
                                break;
                        }
                        Field[] fields = clazz.getDeclaredFields();
                        for (int fieldIndex = 0; fieldIndex < fields.length; fieldIndex++) {
                            if (Modifier.isStatic(fields[fieldIndex].getModifiers())) {
                                continue;
                            }
                            fun.mizhuo.hrserver.anno.Field annotation = fields[fieldIndex].getAnnotation(fun.mizhuo.hrserver.anno.Field.class);
                            if (annotation != null) {
                                fields[fieldIndex].setAccessible(true);
                                String fieldName = annotation.value();
                                if(fieldName.equals(sheet.getRow(0).getCell(cellIndex).getStringCellValue())){
                                    //获取字段类型
                                    Class<?> type = fields[fieldIndex].getType();
                                    String replace = fields[fieldIndex].getName().substring(0, 1).toUpperCase()
                                            + fields[fieldIndex].getName().substring(1);
                                    //获取setter方法
                                    Method setMethod = clazz.getMethod("set" + replace, type);
                                    // ---判断读取数据的类型
                                    if (type.isAssignableFrom(String.class)) {
                                        setMethod.invoke(obj, String.valueOf(cellValue));
                                    } else if (type.isAssignableFrom(int.class)
                                            || type.isAssignableFrom(Integer.class)) {
                                        DecimalFormat decimalFormat = new DecimalFormat("###");
                                        setMethod.invoke(obj, Integer.valueOf(decimalFormat.format((StringUtils.isEmpty(cellValue) || "".equals(cellValue)) ? 0 : cellValue )));
                                    } else if (type.isAssignableFrom(Double.class)
                                            || type.isAssignableFrom(double.class)) {
                                        DecimalFormat decimalFormat = new DecimalFormat("###.##");
                                        setMethod.invoke(obj, Double.valueOf(decimalFormat.format((StringUtils.isEmpty(cellValue) || "".equals(cellValue)) ? 0 : cellValue )));
                                    } else if (type.isAssignableFrom(Boolean.class)
                                            || type.isAssignableFrom(boolean.class)) {
                                        setMethod.invoke(obj, Boolean.parseBoolean(StringUtils.isEmpty(cellValue) ? null : String.valueOf(cellValue)));
                                    } else if (type.isAssignableFrom(Date.class)) {
                                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                        if(StringUtils.isEmpty(cellValue)){
                                            continue;
                                        }
                                        setMethod.invoke(obj, dateFormat.parse(String.valueOf(cellValue)));
                                    } else if (type.isAssignableFrom(Timestamp.class)) {
                                        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        if(StringUtils.isEmpty(cellValue)){
                                            continue;
                                        }
                                        setMethod.invoke(obj, new Timestamp(dateFormat.parse(String.valueOf(cellValue)).getTime()));
                                    }
                                }
                            }
                        }
                    }
                    data.add(obj);
                }
            }
            return data;
        }catch (Exception e){
            throw new HrException("解析文件失败!",e);
        }
    }
}
