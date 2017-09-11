package com.demo.org.SpringDemo01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.org.bean.BeanClass01;
import com.demo.org.bean.BeanClass02;
import com.demo.org.bean.BeanClass03;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("config/service.xml");
//        BeanClass02 bc02 = ac.getBean("bc0222",BeanClass02.class);
//        bc02.showMsg();
        BeanClass03 bc03 = ac.getBean("bc03",BeanClass03.class);
        System.out.println(bc03.getLogCount());
    }
}
