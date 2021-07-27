package com.highrock.test;

/**
 * @ClassName: Calcu
 * @Author: zjw
 * @Description: 运算表达式计算
 * @Date: 2021/07/21 13:58
 * @Version: 1.0
 */
public class Calcu {


    /**
    * @Method:
    * @Author: zjw
    * @Description: 运算符枚举
    * @Date: 2021/07/21 14:00
    **/
    private enum Operator{
        ADD("+",10),SUBTRACT("-",10),MULTIPLY("*",20),DIVIDE("/",20),
        PARENTHESIS_LEFT("(",100),PARENTHESIS_RIGHT(")",100);
        private String operator;
        private int priority;
        Operator(String operator,int priority){
         this.operator=operator;
         this.priority=priority;
        }

    }

    /**
    * @Method:
    * @Author: zjw
    * @Description: 操作数枚举
    * @Date: 2021/07/21 14:09
    * @Version:    1.0
    **/
    private enum Operand{
        ONE("1"),TWO("2"),THREE("3"),FOUR("4"),FIVE("5"),SIX("6"),SEVEN("7"),EIGHT("8"),NINE("9"),ZERO("0"),POINT(".")

        ;

        private String operand;
        Operand(String operand) {
            this.operand=operand;
        }
    }


    /**
    * @Method: getOperator
    * @Author: zjw
    * @Description: 获取字符串所对应的运算符枚举
    * @Date: 2021/07/21 14:22
    * @Param str
    * @Version:    1.0
    **/
    private Operator getOperator(String str){
        for (Operator op:Operator.values()){
            if (str.equals(op.operator)){
                return op;
            }
        }
        return null;
    }



    /**
    * @Method: getOperand
    * @Author: zjw
    * @Description: 获取字符串所对应的操作数枚举
    * @Date: 2021/07/21 14:33
    * @Param str
    **/
    private Operand getOperand(String str){
        for (Operand op:Operand.values()){
            if (str.equals(op.operand)){
                return op;
            }
        }
        return null;
    }

}
