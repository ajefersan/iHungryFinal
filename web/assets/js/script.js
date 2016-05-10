  wow = new WOW(
      {
        animateClass: 'animated',
        offset:       100,
        callback:     function(box) {
          console.log("WOW: animating <" + box.tagName.toLowerCase() + ">")
        }
      }
    );
    wow.init();

   $(document).ready(function(){
    $('.scrollspy').scrollSpy();

    $('#menu, .subs').localScroll({
         target:'body',
         axis:'xy',
         queue:true //one axis at a time
      });
      
      
    
  
  
  
  
  
      });