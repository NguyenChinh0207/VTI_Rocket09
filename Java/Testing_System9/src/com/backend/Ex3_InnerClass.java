package com.backend;

import com.entity.CPU;
import com.entity.Car;
import com.entity.NgayThangNam;
import com.entity.OuterClass;

import javax.annotation.processing.Processor;

public class Ex3_InnerClass {
    public void Question1() {
        CPU cpu = new CPU();
        CPU.Processor processor = cpu.new Processor();
        System.out.println(processor.getCache());
        CPU.Ram ram = cpu.new Ram();
        System.out.println(ram.getClockSpeed());
    }

    public void Question2() {
        Car car = new Car("Mazda", "8WD");
        Car.Engine engine = car.new Engine();
        engine.setEngineType("Crysler");
        car.setEngine(engine);
        System.out.println("Name: " + car.getName() + "," + "type:" + car.getType() + "," + "engine:" + engine.getEngineType());
    }

    public void Question3() {
        OuterClass outerClass = new OuterClass();
        outerClass.show();

        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.show();
    }

    public void Question4() {
        NgayThangNam date = new NgayThangNam();
        date.ngay=31;
        date.thang=10;
        date.nam=2017;

        NgayThangNam.GioPhutGiay time=date.new GioPhutGiay();
        time.gio=10;
        time.phut=15;
        time.giay=30;
        time.xuatThongTin();
    }

}
