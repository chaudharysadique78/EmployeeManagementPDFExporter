import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';

const routes: Routes = [
  {path: 'allemployee', component: EmployeeListComponent},
  {path: 'employee', component: CreateEmployeeComponent},
  {path: '', redirectTo: 'allemployee', pathMatch: 'full'},
  {path: 'updateemployee/:id', component: UpdateEmployeeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],                                                                                                                                                                                                                                                                                                          
  exports: [RouterModule]
})
export class AppRoutingModule { }
