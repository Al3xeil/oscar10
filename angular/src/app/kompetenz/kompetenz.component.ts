import { Component, OnInit } from '@angular/core';
import { Competence, CompetenceType, CompetenceStatus, CompetenceCategory, CompetenceRating, User } from '../_models/index';
import { CompetenceService, UserService } from '../_services/index';
import { ActivatedRoute, Router } from '@angular/router';
import {IStarRatingOnClickEvent, IStarRatingOnRatingChangeEven, IStarRatingIOnHoverRatingChangeEvent} from "angular-star-rating/src/star-rating-struct";

@Component({
  selector: 'app-kompetenz',
  templateUrl: './kompetenz.component.html',
  styleUrls: ['./kompetenz.component.css']
})
export class KompetenzComponent implements OnInit {
    
    private competence: Competence;
    private id: number;
    private sub: any;
    private types: CompetenceType[];
    private status: CompetenceStatus[];
    private categories: CompetenceCategory[];
    private returnUrl = '/kompetenzpflege';
    private rating : CompetenceRating;
    private currentUser : User;
    private selectedStatus: CompetenceStatus;
    private selectedType: CompetenceType;
    onClickResult:IStarRatingOnClickEvent;

  constructor(private competenceService: CompetenceService,
              private userService: UserService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
      this.sub = this.route.params.subscribe(params => {
          this.id = +params['id']; // (+) converts string 'id' to a number

          this.loadCompetence(this.id);
       });
  }
  
  private loadCompetence(id: number) {
      this.competenceService.getById(id)
          .subscribe(competence => {
              if(competence) {
                  this.competence = competence;
                  this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
                  if(this.currentUser.competenceRating){
                      for(let rating of this.currentUser.competenceRating){
                          if(rating.competence.id == competence.id){
                              this.rating = rating;
                          }
                      }
                  }
                  if(!this.rating){
                      this.rating = new CompetenceRating();
                      this.rating.competence = this.competence;
                      this.rating.userID = this.currentUser.id;
                      this.rating.valueRating = 0;
                  }
                  this.loadComboboxContent();
              } else {
                  this.competence = null;
              }
          });
  }
  
  private loadComboboxContent(){
      this.competenceService.getAllCompetenceStatus()
          .subscribe(status => {
          if(status) {
              this.status = [];
              for(let stat of status){
                  this.status.push(stat.competenceStatus);
              }
              this.mapSelectedStatusCombobox();
          } else {
              this.status = null;
          }
      });
      this.competenceService.getAllTypes()
          .subscribe(types => {
          this.types = [];
          if(types) {
              this.types = [];
              for(let competenceType of types){
                  this.types.push(competenceType.competenceType);
              }
              this.mapSelectedTypeCombobox();
          } else {
              this.types = null;
          }
      });
  }
  
  private mapSelectedTypeCombobox(){
      if(this.competence && this.types){
          for(let type of this.types){
              if(type.id == this.competence.type.id){
                  this.selectedType = type;
              }
          }
      }
  }
  
  private mapSelectedStatusCombobox(){
      if(this.competence && this.status){
          for(let stat of this.status){
              if(stat.id == this.competence.status.id){
                  this.selectedStatus = stat;
              }
          }
      }
  }
  
  private onSubmit(){
      this.competence.type = this.selectedType;
      this.competence.status = this.selectedStatus;
      this.competenceService.update(this.competence)
      .subscribe(
          data => {
              this.router.navigate([this.returnUrl]);
          },
          error => {
          });;
  }
  
  onClick = ($event:IStarRatingOnClickEvent) => {
      console.log('onClick $event: ', $event);
      this.onClickResult = $event;
      this.rating.valueRating = this.onClickResult.rating;
      if(this.rating.id){
          for(let rating of this.currentUser.competenceRating){
              if(rating.id == this.rating.id){
                  rating.valueRating = this.rating.valueRating;
              }
          }
      } else {
          this.currentUser.competenceRating.push(this.rating);
      }
      this.userService.update(this.currentUser).subscribe(
              data => {
                 localStorage.setItem('currentUser', JSON.stringify(this.currentUser));
              },
              error => {
              });
  };

}
