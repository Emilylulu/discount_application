import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MayLikeComponent } from './may-like/may-like.component';
import { HistoryComponent } from './history/history.component';
import { SaveComponent } from './save/save.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild([
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
      {
        path: 'entities/mayLike',
        component: MayLikeComponent
      },
      {
        path: 'entities/history',
        component: HistoryComponent
      },
      {
        path: 'entities/save',
        component: SaveComponent
      }
    ])
  ],
  declarations: [MayLikeComponent, HistoryComponent, SaveComponent]
})
export class DiscountApplicationEntityModule {}
