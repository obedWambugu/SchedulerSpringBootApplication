package com.wambuguobed.ScheduleDemo.Domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Teachers")
public class Teacher{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer Id;
        private boolean active = true;
        @Column(nullable = false, length = 45)
        private String firstName;
        @Column(nullable = false, length = 45)
        private String lastName;
        @Column(nullable = false, unique = true, length = 45)
        private String userName;
        private Designation classRoom;
        @Column(nullable = false, unique = true, length = 45)
        private String email;
        @Column(nullable = false, length = 64)
        private String password;

        public Integer getId() {
                return Id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public Designation getClassRoom() {
                return classRoom;
        }

        public void setClassRoom(Designation classRoom) {
                this.classRoom = classRoom;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        @Override
        public String toString() {
                return "Teacher{" +
                        "Id=" + Id +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", classRoom=" + classRoom +
                        ", email='" + email + '\'' +
                        '}';
        }
}
