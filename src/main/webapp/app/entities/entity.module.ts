import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MayLikeComponent } from './may-like/may-like.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild([
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
      {
        path: 'entities/mayLike',
        component: MayLikeComponent
      }
    ])
  ],
  declarations: [MayLikeComponent]
})
export class DiscountApplicationEntityModule {}
