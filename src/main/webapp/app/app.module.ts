import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { DiscountApplicationSharedModule } from 'app/shared/shared.module';
import { DiscountApplicationCoreModule } from 'app/core/core.module';
import { DiscountApplicationAppRoutingModule } from './app-routing.module';
import { DiscountApplicationHomeModule } from './home/home.module';
import { DiscountApplicationEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { JhiMainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    DiscountApplicationSharedModule,
    DiscountApplicationCoreModule,
    DiscountApplicationHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    DiscountApplicationEntityModule,
    DiscountApplicationAppRoutingModule
  ],
  declarations: [JhiMainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [JhiMainComponent]
})
export class DiscountApplicationAppModule {}
