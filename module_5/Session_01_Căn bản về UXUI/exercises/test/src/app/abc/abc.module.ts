import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreateComponent } from './create/create.component';



@NgModule({
    declarations: [CreateComponent],
    exports: [
        CreateComponent
    ],
    imports: [
        CommonModule
    ]
})
export class AbcModule { }
