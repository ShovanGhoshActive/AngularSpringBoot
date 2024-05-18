import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MyservicesService } from './service/myservices.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, ReactiveFormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular-frontend';
  myForm!: FormGroup;
  allNames: any

  constructor(private myService: MyservicesService) { }

  ngOnInit() {
    this.myForm = new FormGroup({
      name: new FormControl('', Validators.required)
    });

    this.getAllNames();
  }

  onSubmit() {
    if (this.myForm.valid) {
      console.log('Form submitted with value:', this.myForm.value);
      const formData = {
        name: this.myForm.get('name')?.value,
      }
      console.log('Form submitted with value:', formData);
      this.myService.saveOrUpdate(formData).subscribe({
        next: (data: any) => {
          console.log('Response:', data);
          this.getAllNames();
        },
        error: (err: any) => {
          console.error('Error:', err);
        }
      });
    }
  }

  getAllNames() {
    this.myService.listOfNames().subscribe({
      next: (data: any) => {
        this.allNames = data?.response;
        console.log('getAllNames Response:', this.allNames);
      },
      error: (err: any) => {
        console.error('getAllNames Error:', err);
      }
    });
  }

  deleteName(name: string) {
    if (confirm(`Are you sure you want to delete ${name}?`)) {
      this.myService.delete(name).subscribe({
        next: (data: any) => {
          console.log(`${name} delete`,data?.response);
          // Update the list of names after deletion
          this.getAllNames();
        },
        error: (err: any) => {

          console.error(`Error deleting ${name}:`, err);
        }
      });
    }
  }

}
