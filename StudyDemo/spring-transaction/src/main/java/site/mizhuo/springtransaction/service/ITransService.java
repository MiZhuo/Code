package site.mizhuo.springtransaction.service;

/**
 * @InterfaceName ITransService
 * @Description:
 * @Author: MiZhuo
 * @Create: 2022-06-30 22:05
 * @Version 1.0
 **/
public interface ITransService {
    void trans(String from_id, String to_id, Double amt);

    void deducFree(String from_id,Double amt);
}
