package com.lhy.cloud.web1.controller;

import com.lhy.cloud.common.constants.Constants;
import com.lhy.cloud.common.dto.ECooperateMer;
import com.lhy.cloud.common.response.Result;
import com.lhy.cloud.common.utils.UUIDUtil;
import com.lhy.cloud.web1.base.BaseController;
import com.lhy.cloud.web1.remote.ECooperateRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wenyixicodedog
 * @create: 2020-08-23
 * @description:
 */
@RestController
@RequestMapping(value = "/eCooperateController")
public class ECooperateController extends BaseController {

    @Autowired
    ECooperateRemote eCooperateRemote;

    /**
     * @date: 2019/5/24
     * @param: [eCooperateMer]
     * @return: Result
     * @description: 新增详情
     */
    @ResponseBody
    @RequestMapping(value = Constants.CLOUD + "/addECooperateMerInfo")
    public Result addECooperateMerInfo() {
        Result result = new Result();
        Map<String, Object> model = new HashMap<>(4);
        try {
            ECooperateMer mer = new ECooperateMer(UUIDUtil.getUNIDX("EC", 30), "A2019022200000001", "测试数据添加", "1556442573307.jpg", "https://www.baidu.com", "1", 12);
            for (int i = 0; i < 1; i++) {
                fixedThreadPool().execute(() -> {
                    try {
                        eCooperateRemote.addECooperateMerInfo(mer);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            result.setResultData(model);
            result.setResultCode(Constants.RESULT_SUCCESS);
        } catch (Exception e) {
            logger.error("系统异常", e);
            result.setResultCode(Constants.RESULT_FAIL);
            result.setResultMessage("系统异常");
        }
        return result;
    }

}
