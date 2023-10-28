import React from 'react';
import img2 from '../img/img2.png';
function Layer2() {
  const [init, setInit]= React.useState({
    tranform:'',
    transition:'',
    tranform2:'',
    transition2:''
});

// React.useEffect(() => {
//   window.addEventListener('scroll', handleScroll);
//   return () => {
//     window.removeEventListener('scroll', handleScroll);
//   };
// }, []);

function handleScroll() {
  setInit({
    tranform:'scale(5)',
    transition:'transform 8s ease',
    transform2:'scale(1.1)',
    transition2:'transform 8s ease'
});
  
  var ele = document.getElementById('id2');
  ele.style.transform = 'scale(1.15)';
  ele.style.transition = 'transform 4s ease';
  
  var ele2 = document.getElementById('layer4');
  if(ele2 !==null){
      setTimeout(function () {
          ele2.remove();
        }, 4000);
  }
}

  return (
    <div className="overlap-container">
      <div className="component component-1">
        <img id='id2' className='img3' src={img2} alt="Component 1" style={{transform:`${init.transform2}`, transition:`${init.transition2}`}}/>
      </div>
      <div id ='layer4' className="component component-2">
        <img id='id1' className='img4' src={img2} alt="Component 2" style={{transform:`${init.tranform}`, transition:`${init.transition}`}} onWheel={handleScroll}/>
      </div>
    </div>
  )
}
export default Layer2;
