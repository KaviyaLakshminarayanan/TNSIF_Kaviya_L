import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class MallAdminService {
  API_URL = 'http://localhost:8088/mall_admin'; //  Base API URL

  constructor(private http: HttpClient) {}

  /** Fetch all mall admins */
  getMallAdmins() {
    return this.http.get(`${this.API_URL}`);
  }

  /**  Register a new mall admin */
  registerMallAdmin(adminData: any) {
    return this.http.post(`${this.API_URL}`, adminData);
  }

  /** Delete a mall admin */
  deleteMallAdmin(adminId: number) {
    return this.http.delete(`${this.API_URL}/${adminId}`);
  }

  /** Update mall admin details */
  updateMallAdmin(admin: any) {
    return this.http.put(`${this.API_URL}/${admin.mallAdminId}`, admin);
  }
}
