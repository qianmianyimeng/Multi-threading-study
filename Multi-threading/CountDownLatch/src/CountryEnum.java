public enum CountryEnum {
    ONE(1,"qi"),two(2,"chu"),three(3,"yan"),four(4,"zha"),five(5,"wei"),six(6,"han");

    public Integer getRetCode() {
        return retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    private Integer retCode;
    private String retMessage;

    CountryEnum(Integer retCode,String retMessage)
    {
        this.retCode=retCode;
        this.retMessage=retMessage;
    }

    public static CountryEnum forEach_CountryEnum(int index)
    {
        CountryEnum[] myArray =CountryEnum.values();
        for (CountryEnum element:myArray)
        {
            if(index==element.getRetCode()){
                return element;
            }
        }

        return null;
    }
}
