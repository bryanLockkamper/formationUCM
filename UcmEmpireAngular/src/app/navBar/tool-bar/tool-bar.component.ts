import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {NbToastrService} from '@nebular/theme';

@Component({
  selector: 'app-tool-bar',
  templateUrl: './tool-bar.component.html',
  styleUrls: ['./tool-bar.component.scss']
})
export class ToolBarComponent implements OnInit {

  buttonConnection : boolean;

  get isConnected(): boolean {
    if (localStorage.getItem('token') != undefined || localStorage.getItem('token') != null )
    {
      return true;
    } else return false;
  }

  constructor(
    private routServ: Router,
    private toastrServ : NbToastrService) { }

  ngOnInit(): void {
    this.buttonConnection = this.isConnected;
  }


  logout(){
    localStorage.clear();
    this.routServ.navigateByUrl('');
    this.toastrServ.success('A bientot !','Deconnexion', {[status]:'success'});
  }
}
