import React from 'react';
import img1 from '../img/img1.png'
import img2 from '../img/img2.png';
function Layer1() {
  const [init, setInit]= React.useState({
    tranform:'',
    transition:'',
    tranform2:'',
    transition2:''
});
  return (
    <div className="overlap-container">
      <div className="component component-1">
        <img className='img1' src={img1} alt="Component 1" style={{transform:`${init.transform2}`, transition:`${init.transition2}`}}/>
      </div>
      <div className="component component-2">
        <img className='img2' src={img2} alt="Component 2"  onClick={()=>{
            setInit({
                tranform:'scale(5)',
                transition:'transform 8s ease',
                transform2:'scale(1.1)',
                transition2:'transform 8s ease'
            })
        }} style={{transform:`${init.tranform}`, transition:`${init.transition}`}}/>
      </div>
    </div>
  )
}
export default Layer1;
