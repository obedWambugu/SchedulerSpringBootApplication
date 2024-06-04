package com.wambuguobed.ScheduleDemo.Controller;

import java.util.Collection;

import com.wambuguobed.ScheduleDemo.Domain.Teacher;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class TeacherUserDetails implements UserDetails {

    private final Teacher teacher;

    public TeacherUserDetails(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return teacher.getPassword();
    }

    @Override
    public String getUsername() {
        return teacher.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName() {
        return teacher.getFirstName() + " " + teacher.getLastName();
    }

}
