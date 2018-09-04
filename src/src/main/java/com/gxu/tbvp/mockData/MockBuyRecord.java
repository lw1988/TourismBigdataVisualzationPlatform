package com.gxu.tbvp.mockData;

import com.gxu.tbvp.domain.Buyrecord;
import com.gxu.tbvp.exception.SelfJSONResult;
import com.gxu.tbvp.service.BuyrecordService;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

public class MockBuyRecord {

    @Resource
    private BuyrecordService buyrecordService;

    @RequestMapping("/MockBuyRecord")
    public SelfJSONResult mockBuyRecord() {

        return SelfJSONResult.ok("success");
    }
}
