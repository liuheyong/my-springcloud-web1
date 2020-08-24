package com.lhy.cloud.web1.remote;

import com.lhy.cloud.common.dto.ECooperateMer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: wenyixicodedog
 * @create: 2020-08-23
 * @description:
 */
@FeignClient(name = "server1", fallback = ECooperateHystrix.class)
public interface ECooperateRemote {

    @RequestMapping(value = "/server1/eCooperateMerController/addECooperateMerInfo")
    String addECooperateMerInfo(@RequestBody ECooperateMer eCooperateMer);

}
