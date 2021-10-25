package com.wjchenge.customerstarter.auto;

import com.wjchenge.customerstarter.bean.Klass;
import com.wjchenge.customerstarter.bean.School;
import com.wjchenge.customerstarter.bean.Student;
import com.wjchenge.customerstarter.properties.CustomerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wj
 * @Date 2021/10/25 10:27
 */
@Configuration
@EnableConfigurationProperties(CustomerProperties.class)
@Import(School.class)
public class AutoConfiguration {

    @Autowired
    CustomerProperties customerProperties;

    @ConditionalOnProperty(prefix = "customer", name = "id")
    @Bean("student100")
    public Student student(){
        Student student = new Student();
        student.setId(customerProperties.getId());
        student.setName(customerProperties.getName());
        return student;
    }

    @ConditionalOnBean(Student.class)
    @Bean
    @Primary
    public Klass klass(){
        Klass klass = new Klass();
        List<Student> students = new ArrayList<>();
        students.add(student());
        klass.setStudents(students);
        return klass;
    }

}
