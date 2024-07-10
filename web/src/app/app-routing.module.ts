import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TeacherListComponent } from './teacher-list/teacher-list.component';
import { TeacherFormComponent } from './teacher-form/teacher-form.component';

const routes: Routes = [
  { path: 'teachers', component: TeacherListComponent },
  { path: 'addteacher', component: TeacherFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
