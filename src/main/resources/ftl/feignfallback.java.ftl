package com.wehgc.remote.creditor.fegin.account.fallback;

import com.baomidou.mybatisplus.extension.api.R;
import com.wehgc.remote.common.util.RUtil;
import com.wehgc.remote.creditor.dto.account.${entity}DTO;
import com.wehgc.remote.creditor.fegin.account.${entity}Feign;
import org.springframework.stereotype.Component;

/**
* ${table.comment!}FeignFallback
*
* @author ${author}
* @since ${date}
*/
@Component
public class ${entity}FeignFallback implements ${entity}Feign {


    @Override
    public R save(${entity}DTO ${entity?uncap_first}Dto) {
        return RUtil.error("保存${table.comment!}信息失败");
    }

    @Override
    public R modify(${entity}DTO ${entity?uncap_first}Dto) {
        return RUtil.error("修改${table.comment!}信息失败");
    }

    @Override
    public R del(Long id) {
        return RUtil.error("删除${table.comment!}信息失败");
    }

    @Override
    public R<${entity}DTO> selectById(Long id) {
        return RUtil.error("根据id查询${table.comment!}信息失败");
    }
}
