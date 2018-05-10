import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TestComponent } from './test/test.component';
import { DisplayGraphAndResultComponent } from './display-graph-and-result/display-graph-and-result.component';
const routes: Routes = [
	{
		path:'main',
		component:DisplayGraphAndResultComponent
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
export const routingComponents = [TestComponent,DisplayGraphAndResultComponent];
