package fun.mizhuo.hrserver.enums;

import org.springframework.util.StringUtils;

/**
 * @author: Mizhuo
 * @time: 2020/9/30 11:47 上午
 * @description: 文件枚举类
 */
public enum FileEnum {

    File_0001("0001","员工信息导入模板.xls","员工信息批量导入模板","/templates/");

    private String code;
    private String fileName;
    private String desc;
    private String filePath;

    FileEnum(String code, String fileName, String desc,String filePath) {
        this.code = code;
        this.fileName = fileName;
        this.desc = desc;
        this.filePath = filePath;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static FileEnum getFileEnumByCode(String code){
        if(StringUtils.isEmpty(code)){
            return null;
        }
        for (FileEnum e : FileEnum.values()) {
            if(code.equals(e.getCode())){
                return e;
            }
        }
        return null;
    }
}
