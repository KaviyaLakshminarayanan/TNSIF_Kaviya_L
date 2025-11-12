import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MallAdminService } from './MallAdmin.service';

interface MallAdmin {
  mallAdminId: number | null;
  username: string;
  email: string;
  password: string;
  loginAttempts: number;
  isActive: boolean;
  lastLoginTime: string | null;
}

@Component({
  selector: 'app-malladmin-root',
  templateUrl: './MallAdmin.component.html',
  styleUrls: ['./MallAdmin.component.scss'],
})
export class MallAdminComponent implements OnInit {
  mallAdmins: MallAdmin[] = [];
  mallAdminToUpdate: MallAdmin = {
    mallAdminId: null,
    username: '',
    email: '',
    password: '',
    loginAttempts: 0,
    isActive: false,
    lastLoginTime: null,
  };

  constructor(private mallAdminService: MallAdminService) {}

  ngOnInit(): void {
    this.getMallAdmins();
  }

  /**
   * Fetches all mall admins from the backend and updates the local state.
   */
  getMallAdmins(): void {
    this.mallAdminService.getMallAdmins().subscribe(
      (response: any) => {
        console.log('Mall Admins fetched:', response); // Check console
        this.mallAdmins = response; // Ensure this assignment works correctly
      },
      (error) => {
        console.error('Error fetching mall admins:', error);
      }
    );
  }
  
  
  

  /**
   * Registers a new MallAdmin using the provided form data.
   * @param registerForm The form containing mall admin data.
   */
  registerMallAdmin(registerForm: NgForm): void {
    if (registerForm.invalid) {
      alert('Please fill in all required fields.');
      return;
    }
    this.mallAdminService.registerMallAdmin(registerForm.value).subscribe(
      () => {
        registerForm.reset();
        this.getMallAdmins();
      },
      (error) => {
        console.error('Error registering mall admin:', error);
        alert('Error registering mall admin. Please try again later.');
      }
    );
  }

  /**
   * Sets the mallAdminToUpdate object for editing.
   * @param mallAdmin The mall admin to edit.
   */
  // Method to set the mallAdminToUpdate object when the Edit button is clicked
  editMallAdmin(mallAdmin: MallAdmin): void {
    this.mallAdminToUpdate = { ...mallAdmin };
  
    // Access the modal element and show it using Bootstrap's JavaScript API
    const modalElement = document.getElementById('editModal');
    if (modalElement) {
      const modal = new window.bootstrap.Modal(modalElement);  // This should work now
      modal.show();  // Manually open the modal
    }
  }
  
  updateMallAdmin(): void {
    if (this.mallAdminToUpdate.mallAdminId) {
      // Ensure lastLoginTime is not null before sending the request
      if (!this.mallAdminToUpdate.lastLoginTime) {
        alert('Last login time cannot be null');
        return;
      }
  
      this.mallAdminService.updateMallAdmin(this.mallAdminToUpdate).subscribe(
        () => {
          this.getMallAdmins();
          alert('Mall Admin updated successfully.');
        },
        (error) => {
          console.error('Error updating mall admin:', error);
          alert('Error updating mall admin');
        }
      );
    } else {
      alert('MallAdmin ID is undefined. Cannot update mall admin.');
    }
  }
  
  

  /**
   * Deletes a mall admin by ID.
   * @param mallAdminId The mall admin ID to delete.
   */
  deleteMallAdmin(mallAdminId: number): void {
    this.mallAdminService.deleteMallAdmin(mallAdminId).subscribe(
      () => {
        this.getMallAdmins();
      },
      (error) => {
        console.error('Error deleting mall admin:', error);
        alert('Error deleting mall admin');
      }
    );
  }
}
