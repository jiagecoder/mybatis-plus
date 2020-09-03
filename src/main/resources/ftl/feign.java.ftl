package com.wehgc.remote.creditor.fegin.account;

import com.baomidou.mybatisplus.extension.api.R;
import com.wehgc.remote.creditor.dto.account.${entity}DTO;
import com.wehgc.remote.creditor.fegin.account.fallback.${entity}FeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
* ${table.comment!}FeignClient
*
* @author ${author}
* @since ${date}
*/
@FeignClient(name = "lucky-creditor", path = "<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>", fallback = ${entity}FeignFallback.class)
public interface ${entity}Feign {

    /**
    * 保存${table.comment!}信息
    * @auther ${author}
    * @Date ${date}
    * @param ${entity?uncap_first}Dto
    * @return
    */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    R save(@RequestBody ${entity}DTO ${entity?uncap_first}Dto);

    /**
    * 修改${table.comment!}信息
    * @auther ${author}
    * @Date ${date}
    * @param ${entity?uncap_first}Dto
    * @return
    */
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    R modify(@RequestBody ${entity}DTO ${entity?uncap_first}Dto);

    /**
    * 删除${table.comment!}信息
    * @auther ${author}
    * @Date ${date}
    * @param id
    * @return
    */
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    R del(@RequestParam Long id);

    /**
    * 根据id查询${table.comment!}信息
    * @auther ${author}
    * @Date ${date}
    * @param id
    * @return
    */
    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    R<${entity}DTO> selectById(@RequestParam Long id);

 }