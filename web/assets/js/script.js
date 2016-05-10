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
     //one axis at a time
        $(".element").typed({
        strings: ["Mate sua forme com alguns clicks.", "Sem gastar muito."],
        typeSpeed: -1
      });
      });
      
      
    
  
  
  
  
  
     