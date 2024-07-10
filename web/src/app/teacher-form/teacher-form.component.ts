import { Component } from '@angular/core';
import { Teacher } from '../teacher';
import { ActivatedRoute, Router } from '@angular/router';
import { TeacherService } from '../teacher.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-teacher-form',
  templateUrl: './teacher-form.component.html',
  styleUrl: './teacher-form.component.css'
})
export class TeacherFormComponent {
  teacher!: Teacher;

  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
        private userService: TeacherService) {
  }

  onSubmit(submitForm: NgForm): void {
    this.userService.addTeacher(submitForm.value).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/teacher/all']);
  }
}
