package com.example.consumer.model.primary;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "online_main_order")
public class OnlineMainOrder {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 主订单号
     */
    @Column(name = "main_order_no")
    private String mainOrderNo;

    /**
     * 订单金额
     */
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    /**
     * SKU编码
     */
    @Column(name = "sku_code")
    private String skuCode;

    /**
     * SKU名称
     */
    @Column(name = "sku_name")
    private String skuName;

    /**
     * 0 待支付；1 支付成功；2 支付失败；3 取消支付；4 拒绝支付
     */
    @Column(name = "order_status")
    private String orderStatus;

    /**
     * 仓库ID
     */
    @Column(name = "warehouse_id")
    private Integer warehouseId;

    /**
     * 付款账号
     */
    @Column(name = "payment_account")
    private String paymentAccount;

    /**
     * 收款账号
     */
    @Column(name = "receive_account")
    private String receiveAccount;

    /**
     * 币别英文简称
     */
    @Column(name = "currency_code")
    private String currencyCode;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 创建人ID
     */
    @Column(name = "create_id")
    private Integer createId;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 修改人ID
     */
    @Column(name = "update_id")
    private Integer updateId;

    /**
     * 修改人
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 修改时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取主订单号
     *
     * @return main_order_no - 主订单号
     */
    public String getMainOrderNo() {
        return mainOrderNo;
    }

    /**
     * 设置主订单号
     *
     * @param mainOrderNo 主订单号
     */
    public void setMainOrderNo(String mainOrderNo) {
        this.mainOrderNo = mainOrderNo;
    }

    /**
     * 获取订单金额
     *
     * @return total_amount - 订单金额
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * 设置订单金额
     *
     * @param totalAmount 订单金额
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * 获取SKU编码
     *
     * @return sku_code - SKU编码
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * 设置SKU编码
     *
     * @param skuCode SKU编码
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    /**
     * 获取SKU名称
     *
     * @return sku_name - SKU名称
     */
    public String getSkuName() {
        return skuName;
    }

    /**
     * 设置SKU名称
     *
     * @param skuName SKU名称
     */
    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    /**
     * 获取0 待支付；1 支付成功；2 支付失败；3 取消支付；4 拒绝支付
     *
     * @return order_status - 0 待支付；1 支付成功；2 支付失败；3 取消支付；4 拒绝支付
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置0 待支付；1 支付成功；2 支付失败；3 取消支付；4 拒绝支付
     *
     * @param orderStatus 0 待支付；1 支付成功；2 支付失败；3 取消支付；4 拒绝支付
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取仓库ID
     *
     * @return warehouse_id - 仓库ID
     */
    public Integer getWarehouseId() {
        return warehouseId;
    }

    /**
     * 设置仓库ID
     *
     * @param warehouseId 仓库ID
     */
    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    /**
     * 获取付款账号
     *
     * @return payment_account - 付款账号
     */
    public String getPaymentAccount() {
        return paymentAccount;
    }

    /**
     * 设置付款账号
     *
     * @param paymentAccount 付款账号
     */
    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    /**
     * 获取收款账号
     *
     * @return receive_account - 收款账号
     */
    public String getReceiveAccount() {
        return receiveAccount;
    }

    /**
     * 设置收款账号
     *
     * @param receiveAccount 收款账号
     */
    public void setReceiveAccount(String receiveAccount) {
        this.receiveAccount = receiveAccount;
    }

    /**
     * 获取币别英文简称
     *
     * @return currency_code - 币别英文简称
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * 设置币别英文简称
     *
     * @param currencyCode 币别英文简称
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取创建人ID
     *
     * @return create_id - 创建人ID
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * 设置创建人ID
     *
     * @param createId 创建人ID
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 获取创建人
     *
     * @return create_user - 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人
     *
     * @param createUser 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取修改人ID
     *
     * @return update_id - 修改人ID
     */
    public Integer getUpdateId() {
        return updateId;
    }

    /**
     * 设置修改人ID
     *
     * @param updateId 修改人ID
     */
    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取修改人
     *
     * @return update_user - 修改人
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置修改人
     *
     * @param updateUser 修改人
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 获取修改时间
     *
     * @return update_date - 修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置修改时间
     *
     * @param updateDate 修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}