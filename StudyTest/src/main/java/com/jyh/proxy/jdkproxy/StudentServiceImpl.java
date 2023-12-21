package com.jyh.proxy.jdkproxy;

public class StudentServiceImpl implements IStudentService{
    private String name;

    public StudentServiceImpl() {
    }

    public StudentServiceImpl(String name) {
        this.name = name;
    }

    @Override
    public String sing(String songName) {
        System.out.println(this.name + "正在唱：" + songName);
        return this.name + "：谢谢大家！";
    }

    @Override
    public String dance() {
        System.out.println(this.name + "正在跳舞");
        return this.name + "：谢谢大家！";
    }
}
