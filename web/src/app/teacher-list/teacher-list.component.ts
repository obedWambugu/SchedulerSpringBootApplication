import { Component, OnInit } from '@angular/core';
import { Teacher } from '../teacher';
import { TeacherService } from '../teacher.service';

@Component({
  selector: 'app-teacher-list',
  templateUrl: './teacher-list.component.html',
  styleUrl: './teacher-list.component.css'
})
export class TeacherListComponent implements OnInit {

  teachers: Teacher[] = [];

  constructor(private teacherService: TeacherService) {
  }

  ngOnInit() {
    this.teacherService.getTeachers().subscribe(data => {
      this.teachers = data;
    });
  }
}
