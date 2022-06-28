package fun.mizhuo.hrserver.controller.common;

import fun.mizhuo.hrserver.enums.FileEnum;
import fun.mizhuo.hrserver.exception.HrException;
import fun.mizhuo.hrserver.model.ResponseVo;
import fun.mizhuo.hrserver.service.common.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Mizhuo
 * @time: 2020/9/19 9:09 下午
 * @description: 公用Controller
 */
@Api(value = "公共Controller",tags = {"公共接口"})
@RestController
@RequestMapping("/common")
public class CommonController {
    @Autowired
    private CommonService commonService;

    @ApiOperation(value = "获取下拉列表")
    @GetMapping("/dropDown/{arr}")
    public ResponseVo getDropDownList(@PathVariable String[] arr){
        Map<String, Object> data = new HashMap<>();
        for (String code : arr) {
            List<Map<String,String>> codeData = commonService.getDropDownList(code);
            data.put(code,codeData);
        }
        return ResponseVo.ok("",data);
    }

    @ApiOperation(value = "下载文件")
    @GetMapping("/downloadFile/{fileCode}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileCode) throws HrException {
        try {
            FileEnum fileEnum = FileEnum.getFileEnumByCode(fileCode);
            if (fileEnum != null) {
                //获取文件路径
                String path = fileEnum.getFilePath() + fileEnum.getFileName();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentDispositionFormData("attachment", new String(fileEnum.getFileName().getBytes("GBK"), "iso-8859-1"));
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                //获取文件输入流
                ClassPathResource classPathResource = new ClassPathResource(path);
                InputStream in = classPathResource.getInputStream();
                byte[] data = new byte[in.available()];
                in.read(data);
                return new ResponseEntity<byte[]>(data, headers, HttpStatus.OK);
            }
            return null;
        }catch (Exception e){
            throw new HrException("下载文件失败!",e);
        }
    }
} 
