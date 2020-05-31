package day16;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @Author: YiBin
 * @Description: 实体类封装，对应着excel用例字段
 * @Date: Created in 下午 03:20 20/05/15
 * @Modified By:
 */
public class CaseInfo {
    @Excel(name="用例编号")
    private int caseId;
    @Excel(name="接口名称")
    private String name;
    @Excel(name="url")
    private String url;
    @Excel(name="请求方式")
    private String type;
    @Excel(name="用例描述")
    private String desc;
    @Excel(name="参数")
    private String params;
    @Excel(name="参数类型")
    private String contentType;

    public CaseInfo() {
    }

    public CaseInfo(int caseId, String name, String url, String type, String desc, String params, String contentType) {
        this.caseId = caseId;
        this.name = name;
        this.url = url;
        this.type = type;
        this.desc = desc;
        this.params = params;
        this.contentType = contentType;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
