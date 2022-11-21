package com.redis;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2022-03-08
 * Time: 11:00
 */
public class RedisTest {

    /*@RequestMapping(value = "/orderPayAndroid", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(notes = "安卓支付", httpMethod = "POST", response = AccountPayRet.class, value = "安卓支付")
    public AccountPayRet orderPayAndroid(@RequestBody BaseJson<AliPaySignDto> accountPayDto) {
        AccountPayRet ret = new AccountPayRet();
        String success = "0";
        String msg = "成功";
        AliPaySignDto tAliPaySignDto = accountPayDto.getBody();
        Long aLong = 0L;
        try {
            ret = orderService.orderPayAndroid(tAliPaySignDto, 2);
            // 没有第三方支付的数据处理
            if ("0".equals(ret.getType())) {
                aLong = RedisUtil.setNXData(Constants.PAY_ORDER_ID_ + tAliPaySignDto.getOrderId(), Constants.LOCK, Constants.LOCK_TIMES);
                if (aLong == 1) {
                    PayerEnum payer = PayerEnum.APP;
                    PayChannelEnum channel = PayChannelEnum.ACCOUNT;
                    PayeeEnum payee = PayeeEnum.LETZGO;
                    payChannelInfoService.addPayChannelInfo(payer, channel, payee, tAliPaySignDto.getOrderId());
                    orderPayCallBackServer.pay(ret.getOrderId(), Constants.FULL_OR_PART_ZERO, true);
                } else {
                    throw new BizDataException("此订单正在支付中");
                }
            }
        } catch (PayException e) {
            success = "3";//验证失败
            msg = e.getMessage();
            e.printStackTrace();
            log.error(msg);
        } catch (BizDataException e) {
            success = "1";//验证失败
            msg = e.getMessage();
            e.printStackTrace();
            log.error(msg);
        } catch (Exception e) {
            success = "2";//系统异常
            msg = Constants.SYS_ERROR;
            e.printStackTrace();
            log.error("orderPayAndroid exception，param：{}", JSONObject.toJSONString(tAliPaySignDto), e);
        } finally {
            if (aLong == 1) {
                RedisUtil.delData(Constants.PAY_ORDER_ID_ + tAliPaySignDto.getOrderId());
            }
        }
        ret.setMsg(msg);
        ret.setSuccess(success);
        return ret;
    }*/

}
