import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from "./list/list.component";
import {CreateComponent} from "./create/create.component";
import {DetailComponent} from "./detail/detail.component";
import {EditComponent} from "./edit/edit.component";


const routes: Routes = [
  {path: "home",component: ListComponent},
  {path: "create",component: CreateComponent},
  {path: "detail/:id",component: DetailComponent},
  {path: "edit/:id",component: EditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
