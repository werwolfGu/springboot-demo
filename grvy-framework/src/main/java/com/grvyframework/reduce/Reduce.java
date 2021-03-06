package com.grvyframework.reduce;

import com.grvyframework.model.BaseScriptEvalResult;
import com.grvyframework.reduce.impl.ReduceAllOf;
import com.grvyframework.reduce.impl.ReduceAnyOf;
import com.grvyframework.reduce.impl.ReduceFirstOf;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author chengen.gce
 * @date 2020-01-21 13:36
 * @description
 */
public abstract class Reduce<T extends BaseScriptEvalResult> {

    protected Predicate predicate;

    protected List<T> result = new ArrayList<>();

    public Reduce(Predicate predicate){
        this.predicate = predicate;
    }

    /**
     * 获取结果判断
     * @param data
     * @return
     */
    public abstract boolean execute(T data);

    public List<T> getResult(){

        return result;
    }

    public static <V extends BaseScriptEvalResult> Reduce<V> firstOf(Predicate<V> predicate){

        return new ReduceFirstOf(predicate);
    }

    public static <V extends BaseScriptEvalResult> Reduce<V> anyof(Predicate<V> predicate){
        return new ReduceAnyOf(predicate);
    }

    public static  <V extends BaseScriptEvalResult> Reduce<V> allof(Predicate<V> predicate){
        return new ReduceAllOf(predicate);
    }

    public static void main(String[] args) {

        Reduce<BaseScriptEvalResult> first = Reduce.firstOf(Objects::nonNull);
        BaseScriptEvalResult result = new BaseScriptEvalResult();
        first.execute(result);
        System.out.println(first.getResult());

        Reduce<BaseScriptEvalResult> allof = Reduce.allof(Objects::nonNull);
        for (int i = 0 ; i < 10 ; i++ ){
            BaseScriptEvalResult r = new BaseScriptEvalResult();
            if ( allof.execute(r)){
                break;
            }
        }
        System.out.println(allof.getResult());

        Reduce<BaseScriptEvalResult> anyof = Reduce.anyof(Objects::nonNull);
        for (int i = 0 ; i < 10 ; i++ ){
            BaseScriptEvalResult r = new BaseScriptEvalResult();
            if (anyof.execute(r)){
                break;
            }
        }
        System.out.println(anyof.getResult());
    }
}
