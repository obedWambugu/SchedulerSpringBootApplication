package com.wambuguobed.ScheduleDemo.Domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="TimeTable")
public class TimeTable{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer Id;
        private LocalDate date;
        private LocalTime time;
        private String subject;
        private Designation classRoom;
        // Check on table joins in jpa
        public String teacher;

        public Integer getId() {
                return Id;
        }

        public LocalDate getDate() {
                return date;
        }

        public void setDate(LocalDate date) {
                this.date = date;
        }

        public LocalTime getTime() {
                return time;
        }

        public void setTime(LocalTime time) {
                this.time = time;
        }

        public String getSubject() {
                return subject;
        }

        public void setSubject(String subject) {
                this.subject = subject;
        }

        public Designation getClassRoom() {
                return classRoom;
        }

        public void setClassRoom(Designation classRoom) {
                this.classRoom = classRoom;
        }

        public String getTeacher() {
                return teacher;
        }

        public void setTeacher(String teacher) {
                this.teacher = teacher;
        }

        @Override
        public String toString() {
                return "TimeTable{" +
                        "Id=" + Id +
                        ", date='" + date + '\'' +
                        ", time='" + time + '\'' +
                        ", subject='" + subject + '\'' +
                        ", classRoom='" + classRoom + '\'' +
                        ", teacher='" + teacher + '\'' +
                        '}';
        }
}


