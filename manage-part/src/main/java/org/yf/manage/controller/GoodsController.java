package org.yf.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yf.common.vo.GoodsVo;
import org.yf.common.response.PageParam;
import org.yf.common.response.Response;
import org.yf.manage.service.IGoodsService;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author yfqlzlx
 * @date 2019/4/10 22:25
 *
 * 商品管理类
 */
@RestController
@Slf4j
@RequestMapping(value = "/api/goods")
public class GoodsController {
    private IGoodsService goodsService;
    public GoodsController(IGoodsService goodsService){
        this.goodsService = goodsService;
    }

    /**
     * 添加商品
     * @param vo 待添加商品(商品信息 + 图片地址)
     * @return response
     */
    @PostMapping(value = "/add")
    public Response addGoods(@RequestBody GoodsVo vo) throws  Exception{
        log.debug("添加商品接收参数：" + vo);
        if(goodsService.addGoods(vo)){
            return new Response(200);
        }
        return new Response(500);
    }

    /**
     * 分页获取商品
     * @param pageNo 当前页数
     * @param pageSize 分页大小
     * @return response
     */
    @GetMapping(value = "/all")
    public Response getAllGoods(@RequestParam(value = "page", defaultValue = "1") int pageNo,
                                @RequestParam(value = "limit", defaultValue = "10") int pageSize){
        return goodsService.getPagedGoods(pageNo,pageSize);
    }

    /**
     * 根据条件，分页查询商品
     * @param param 查询参数
     * @return response
     */
    @PostMapping(value = "/query")
    public Response queryGoods(@RequestBody PageParam param){
        log.debug("参数:" + param);
        return goodsService.queryGoods(param);
    }

    /**
     * 根据商品id删除商品
     * @param id id
     * @return response
     */
    @DeleteMapping(value = "/del/{id}")
    public Response delGoods(@PathVariable int id){
        if(goodsService.delGoods(id)){
            return new Response(200);
        }
        return new Response(500);
    }

    /**
     * 商品图片上传
     * @param files 图片s
     * @return 图片的存储文件名
     */
    @PostMapping(value = "/upload/img")
    public Response uploadImg(@RequestParam(value = "file",required = false) MultipartFile[] files){
        log.debug("文件上传:"+ LocalDateTime.now());
        List<String> fileNames = new ArrayList<>();
        Arrays.asList(files).forEach(item-> {
            // 后缀
            String suffix = item.getOriginalFilename().substring(item.getOriginalFilename().lastIndexOf("."));
            // 生成新文件名
            String newFileName = UUID.randomUUID().toString().replaceAll("-", "");
            // 文件全称
            String fullFileName = newFileName + suffix;
            fileNames.add(fullFileName);
            try {
                FileCopyUtils.copy(item.getBytes(), new FileOutputStream("D:\\素材\\gd\\"+ fullFileName));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return new Response(200,fileNames);
    }

}
