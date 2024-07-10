import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { Teacher } from './teacher';
import { environment } from '../environments/environments';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getTeachers(): Observable<Teacher[]>{
    return this.http.get<Teacher[]>(`${this.apiServerUrl}/teacher/all`);
  }

  public getTeacher(teacher: { firstName: Teacher;}): Observable<Teacher>{
    return this.http.post<Teacher>(`${this.apiServerUrl}/teacher/name`, teacher.firstName);
  }

  addTeacher(teacher: Teacher): Observable<Teacher> {
    {
      const headers = new HttpHeaders({
        'Content-Type': 'application/json'
      });
    return this.http.post<Teacher>(`${this.apiServerUrl}/teacher/add`, teacher, {headers});
  }
}

  public updateTeacher(teacherId: number, teacher: Teacher): Observable<Teacher>{
    return this.http.put<Teacher>(`${this.apiServerUrl}/teacher/updatePassword/${teacherId}`, teacher);
  }
  
  public deleteTeacher(teacherId: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/teacher/delete/${teacherId}`);
  }

}
