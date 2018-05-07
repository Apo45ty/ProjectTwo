import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TestComponent } from './test/test.component';

const routes: Routes = [
	{
		path:'main',
		component:TestComponent
	},
	{
		path:'**',redirectTo:'main',pathMatch:'full'
	}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [TestComponent];
