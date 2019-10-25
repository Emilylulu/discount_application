import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { errorRoute } from './layouts/error/error.route';
import { navbarRoute } from './layouts/navbar/navbar.route';
import { DEBUG_INFO_ENABLED } from './app.constants';

import { UserRouteAccessService } from './core/auth/user-route-access-service';

import { ClothComponent } from './cloth/cloth.component';
import { ItemComponent } from './item/item.component';
import { GameComponent } from './game/game.component';
import { BookComponent } from './book/book.component';
import { PurseComponent } from './purse/purse.component';
import { ToyComponent } from './toy/toy.component';
import { JewelryComponent } from './jewelry/jewelry.component';

const LAYOUT_ROUTES = [navbarRoute, ...errorRoute];

@NgModule({
  imports: [
    RouterModule.forRoot(
      [
        {
          path: 'admin',
          data: {
            authorities: ['ROLE_ADMIN']
          },
          canActivate: [UserRouteAccessService],
          loadChildren: () => import('./admin/admin-routing.module').then(m => m.AdminRoutingModule)
        },
        {
          path: 'account',
          loadChildren: () => import('./account/account.module').then(m => m.DiscountApplicationAccountModule)
        },
        {
          path: 'cloth',
          component: ClothComponent
        },
        {
          path: 'item/:id',
          component: ItemComponent
        },
        {
          path: 'game',
          component: GameComponent
        },
        {
          path: 'book',
          component: BookComponent
        },
        {
          path: 'purse',
          component: PurseComponent
        },
        {
          path: 'toy',
          component: ToyComponent
        },
        {
          path: 'jewelry',
          component: JewelryComponent
        },
        ...LAYOUT_ROUTES
      ],
      { enableTracing: DEBUG_INFO_ENABLED }
    )
  ],
  exports: [RouterModule]
})
export class DiscountApplicationAppRoutingModule {}
