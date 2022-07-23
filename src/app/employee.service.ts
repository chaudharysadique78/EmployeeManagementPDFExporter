import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})

export class EmployeeService {
  
  private BaseUrl = "http://localhost:9999/user/allemployee";
  private Base_Url = "http://localhost:9999/user/employee";
  private Base_Urlid = "http://localhost:9999/user/employee";
  private Base_Urlup = "http://localhost:9999/user/updateemployee";
  private Base_Urldel = "http://localhost:9999/user/deleteemployee";







  constructor(private httpClient: HttpClient) { }

  getEmployeeList(): Observable<Employee[]> {
console.log('${this.BaseUrl}');
return this.httpClient.get<Employee[]>(`${this.BaseUrl}`);
}

createEmployee(employee: Employee): Observable<Object>{
  return this.httpClient.post(`${this.Base_Url}`, employee);
}

getEmployeeById(id: number): Observable<Employee>{
  return this.httpClient.get<Employee>(`${this.Base_Urlid}/${id}`);
}
updateEmployee(id: number, employee: Employee): Observable<Object>{
  return this.httpClient.put(`${this.Base_Urlup}/${id}`, employee);
}

deleteEmployee(id: number): Observable<Object>{
  return this.httpClient.delete(`${this.Base_Urldel}/${id}`);
}

}
