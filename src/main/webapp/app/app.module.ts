import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MDBBootstrapModule } from 'angular-bootstrap-md';

import './vendor';
import { DiscountApplicationSharedModule } from './shared/shared.module';
import { DiscountApplicationCoreModule } from './core/core.module';
import { DiscountApplicationAppRoutingModule } from './app-routing.module';
import { DiscountApplicationHomeModule } from './home/home.module';
import { DiscountApplicationEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { JhiMainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';
import { ClothComponent } from './cloth/cloth.component';
import { ItemComponent } from './item/item.component';
import { GameComponent } from './game/game.component';
import { BookComponent } from './book/book.component';
import { PurseComponent } from './purse/purse.component';
import { ToyComponent } from './toy/toy.component';
import { JewelryComponent } from './jewelry/jewelry.component';

@NgModule({
  declarations: [
    JhiMainComponent,
    NavbarComponent,
    ErrorComponent,
    PageRibbonComponent,
    FooterComponent,
    ClothComponent,
    ItemComponent,
    GameComponent,
    BookComponent,
    PurseComponent,
    ToyComponent,
    JewelryComponent
  ],
  imports: [
    BrowserModule,
    DiscountApplicationSharedModule,
    DiscountApplicationCoreModule,
    DiscountApplicationHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    DiscountApplicationEntityModule,
    DiscountApplicationAppRoutingModule,
    NgbModule,
    MDBBootstrapModule.forRoot()
  ],
  bootstrap: [JhiMainComponent]
})
export class DiscountApplicationAppModule {}
