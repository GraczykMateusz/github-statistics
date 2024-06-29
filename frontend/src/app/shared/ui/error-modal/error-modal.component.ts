import { Component, inject, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-error-modal',
  standalone: true,
  imports: [],
  templateUrl: './error-modal.component.html',
  styleUrl: './error-modal.component.scss'
})
export class ErrorModalComponent {
  @Input({required: true}) public message!: string;
  
  private readonly activeModal = inject(NgbActiveModal);
  
  close(): void {
    this.activeModal.close();
  }
}
