
var CustomDropzoneRemoveFromRollUp = Class.create();

CustomDropzoneRemoveFromRollUp.prototype = (new Rico.Dropzone()).extend( {

   initialize: function( htmlElement, header ) {
      this.htmlElement  = $(htmlElement);
      this.header       = $(header);
      this.absoluteRect = null;
      
      this.acceptedObjects = [];

      this.offset = navigator.userAgent.toLowerCase().indexOf("msie") >= 0 ? 0 : 1;
   },

   activate: function() {
  
  new Effect.FadeTo( this.htmlElement, .4, 450, 6 );
  
   },

   deactivate: function() {
      new Effect.FadeTo( this.htmlElement, 1, 450, 4 );
   },

   showHover: function() {
      if ( this.showingHover )
         return;
     if(this.header!= null){
      this.header.style.color = "#000000";
     }
      new Effect.FadeTo( this.htmlElement, .90, 250, 4 );
      this.showingHover = true;
   },

   hideHover: function() {
      if ( !this.showingHover )
         return;
     if(this.header!= null){
      this.header.style.color = "#5b5b5b";
     }
      new Effect.FadeTo( this.htmlElement, .4, 450, 4 );
      this.showingHover = false;
   },


   accept: function(draggableObjects) {

      n = draggableObjects.length;
      var removeString="";
      for ( var i = 0 ; i < n ; i++ )
      {
	  this._insertSorted(draggableObjects[i]);
      removeString = removeString+"splitme"+draggableObjects[i].name;
      }
  	 
 

 
 location.replace("http://localhost:8080/menumine/removeRollUp.action?target="+removeString);
 
 
   },

   canAccept: function(draggableObjects) {
   

      return true;
   },

   _insertSorted: function( aDraggable ) {
      var theGUI = aDraggable.getDroppedGUI();
      var thisName = aDraggable.name;
      var position = this._getInsertPosition(aDraggable);
      if ( position == "append" )
         this.htmlElement.appendChild(theGUI);
      else
         this.htmlElement.insertBefore( theGUI, this.htmlElement.childNodes[position+this.offset]  );
      this.acceptedObjects[ this.acceptedObjects.length ] = aDraggable.name;
      this.acceptedObjects.sort();
   },

   _getInsertPosition: function(aDraggable) {
      for( var i = 0 ; i < this.acceptedObjects.length ; i++ )
         if ( aDraggable.name < this.acceptedObjects[i] ) {
            return i;
         }
       return "append";
   }

} );