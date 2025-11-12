import { Component, OnInit } from '@angular/core';
import { MallAdminService } from './MallAdmin.service';

@Component({
  selector: 'app-mall-admin',
  templateUrl: './MallAdmin.component.html',
  styleUrls: ['./MallAdmin.component.css']
})
export class MallAdminComponent implements OnInit {
  public title: string = 'Mall Admin';

  constructor(private mallAdminService: MallAdminService) { }

  ngOnInit(): void {
    this.getMallAdmins();
  }

  getMallAdmins(): void {
    this.mallAdminService.getMallAdmins().subscribe(
      (data) => {
        // handle the response data
      },
      (error) => {
        // handle the error
      }
    );
  }
}
