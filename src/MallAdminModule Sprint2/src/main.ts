import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { MallAdminModule } from './app/MallAdmin.module';

platformBrowserDynamic()
  .bootstrapModule(MallAdminModule)
  .catch((err) => console.error(err));

  declare global {
    interface Window {
      bootstrap: any;
    }
  }
