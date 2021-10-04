import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateStudentComponent } from './create-student/create-student.component';
import { ErrorComponent } from './error/error.component';
import { StudentlistComponent } from './studentlist/studentlist.component';
import { UpdateStudentComponent } from './update-student/update-student.component';

const routes: Routes = [
  {path:"",redirectTo:"allstudent",pathMatch:'full'},
  {path:"allstudent",component:StudentlistComponent},
  {path:"createstudent",component:CreateStudentComponent},
  {path:"update-employee/:id",component:UpdateStudentComponent},
{path:"**",component:ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
