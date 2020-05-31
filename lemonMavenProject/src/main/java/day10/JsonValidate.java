package day10;

/**
 * 第二题：描述JsonValidate类
 */

public class JsonValidate {
    //通过分析json字符串的字段，JsonValidate应该包含如下属性
    private String value;
    private String expression;

    public JsonValidate() {
    }

    public JsonValidate(String value, String expression) {
        this.value = value;
        this.expression = expression;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
