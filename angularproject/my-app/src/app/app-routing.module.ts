import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TestComponent } from './test/test.component';
import { FullpageComponent } from './fullpage/fullpage.component';
const routes: Routes = [
	{
		path:'',
		component:FullpageComponent
	},
	{
		path:'**',redirectTo:'',pathMatch:'full'
	}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [TestComponent];
